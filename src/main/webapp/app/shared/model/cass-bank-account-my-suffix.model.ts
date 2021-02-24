import { AccountTypeEnum } from '@/shared/model/enumerations/account-type-enum.model';
export interface ICassBankAccountMySuffix {
  id?: string;
  userId?: string | null;
  name?: string;
  bankNumber?: number | null;
  agencyNumber?: number | null;
  lastOperationDuration?: number | null;
  meanOperationDuration?: number | null;
  balance?: number;
  lastOperationDate?: Date | null;
  active?: boolean | null;
  pictureContentType?: string | null;
  picture?: string | null;
  operationsFileContentType?: string | null;
  operationsFile?: string | null;
  accountType?: AccountTypeEnum | null;
}

export class CassBankAccountMySuffix implements ICassBankAccountMySuffix {
  constructor(
    public id?: string,
    public userId?: string | null,
    public name?: string,
    public bankNumber?: number | null,
    public agencyNumber?: number | null,
    public lastOperationDuration?: number | null,
    public meanOperationDuration?: number | null,
    public balance?: number,
    public lastOperationDate?: Date | null,
    public active?: boolean | null,
    public pictureContentType?: string | null,
    public picture?: string | null,
    public operationsFileContentType?: string | null,
    public operationsFile?: string | null,
    public accountType?: AccountTypeEnum | null
  ) {
    this.active = this.active ?? false;
  }
}
